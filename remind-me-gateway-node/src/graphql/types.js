const { gql } = require('apollo-server');

module.exports.typeDefs = gql`
    type Reminder {
        id: ID!
        remindTo: String
        type: String
    }
    
    # The "Query" type is the root of all GraphQL queries.
    # (A "Mutation" type will be covered later on.)
    type Query {
        reminders: [Reminder]
        reminder(id: ID!): Reminder
    }
    
`;