# remind-me-gateway-node

https://www.apollographql.com/docs/apollo-server/essentials/server/#server-integrations

## Running the server
```bash
node src/app.js
```

## Running Queries
Access `http://localhost:3000/graphql` and:

- Query all reminders
```graphql
{
  reminders {
    id
    remindTo
    type
  }
}
```

- Query single reminder
```gaphql
{
  reminder(id: "15d6768f-30e8-44bc-a035-8eade91b314d"){
    id
    remindTo
    type
  }
}
```