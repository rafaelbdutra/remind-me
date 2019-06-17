import * as React from "react";
import { graphql } from 'react-apollo';
import { QUERY_ALL_REMINDERS } from "./query";
import { Reminder } from "../../generated/graphql";

class MyCounter extends React.Component {

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

        if (data.loading) {
            return( <div>Loading reminders...</div> );
        }

        return data.reminders.map(reminder => <li> { reminder.remindTo } </li>);
    };

    render() {
        console.log(this.props);
        return (
            <div>
                <h2>{this.state.count}</h2>
                <button onClick={this.increment}>+</button>
                <button onClick={this.decrement}>-</button>
                <ul id="reminder-list">
                    { this.displayReminders() }
                </ul>
            </div>
        )
    }
}

export default graphql(QUERY_ALL_REMINDERS)(MyCounter);