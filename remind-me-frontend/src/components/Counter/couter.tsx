import * as React from "react";
import { graphql } from 'react-apollo';
import { ChildProps } from 'react-apollo/types';
import { QUERY_ALL_REMINDERS } from "../../queries/queries";
import { GetAllReminders } from "../../queries/types/GetAllReminders";

type CounterProps = ChildProps<{}, GetAllReminders>

class MyCounter extends React.Component<CounterProps> {

    state = {
        count: 0,
    };

    increment = () => {
        this.setState({
            count: this.state.count + 1
        });
    };

    decrement = () => {
        this.setState({
            count: this.state.count - 1
        });
    };

    displayReminders = () => {
        const data = this.props.data;

        if (!data || data.loading || !data.reminders) {
            return( <div>Loading reminders...</div> );
        }

        return data.reminders
            .map(reminder => <li> {reminder!.remindTo} </li>);
    };

    render() {
        console.log(this.props);
        return (
            <div>
                <h2>{this.state.count}</h2>
                <button onClick={this.increment}>+</button>
                <button onClick={this.decrement}>-</button>
                <ul id="reminder-list">
                    { console.log(this.displayReminders()) }
                    { this.displayReminders() }
                </ul>
            </div>
        )
    }
}

export default graphql<{}, GetAllReminders>(QUERY_ALL_REMINDERS)(MyCounter);