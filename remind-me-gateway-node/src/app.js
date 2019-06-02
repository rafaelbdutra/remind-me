const express = require('express');
const { ApolloServer } = require('apollo-server-express');
const { typeDefs } = require('./graphql/types');
const { resolvers } = require('./graphql/resolvers');

const eureka = require('./eureka/eureka');

const app = express();
const port = 3000;

// create graphql server
const graphQLServer = new ApolloServer({ typeDefs, resolvers });
graphQLServer.applyMiddleware({ app });

// connect to eureka
eureka.connect();

const server = app.listen({ port }, () =>
    console.log(`🚀 Server ready at http://localhost:${port}${graphQLServer.graphqlPath}`)
);


const query = require('./query/reminder-query');
app.get('/test', (req, res) => {
    query.getAllReminders().then((r) => {
        res.send(r.body);
    });
});

process.on('SIGTERM', () => {
    quit();
});
process.on('SIGINT', () => {
    quit();
});

quit = () => {
    server.close(() => {
        console.log('Closing http server');
        graphQLServer.stop();
        eureka.disconnect();
    });
};