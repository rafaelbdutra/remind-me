import * as React from "react";
import ApolloClient from 'apollo-boost';
import { ApolloProvider } from 'react-apollo';
import { ApolloProvider as ApolloHooksProvider } from 'react-apollo-hooks';


// components
import MyCounter from './components/Counter/couter';

const client = new ApolloClient({
    uri: "http://localhost:3000/graphql"
});

const App = () => {
    return (
        <ApolloProvider client={client}>
            <ApolloHooksProvider client={client}>
                <div>
                    <h1>Reminders</h1>
                    <MyCounter />
                </div>
            </ApolloHooksProvider>
        </ApolloProvider>
    );
};

export default App;