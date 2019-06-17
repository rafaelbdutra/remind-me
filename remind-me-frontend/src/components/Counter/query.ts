import { gql } from 'apollo-boost';

export const QUERY_ALL_REMINDERS = gql`
    {
        reminders {
            id
            remindTo
            type
        }
    }
`;