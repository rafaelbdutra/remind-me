import { gql } from 'apollo-boost';

export const QUERY_ALL_REMINDERS = gql`
    query GetAllReminders {
        reminders {
            id
            remindTo
            type
        }
    }
`;