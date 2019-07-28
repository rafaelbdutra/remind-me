/* tslint:disable */
/* eslint-disable */
// This file was automatically generated and should not be edited.

// ====================================================
// GraphQL query operation: GetAllReminders
// ====================================================

export interface GetAllReminders_reminders {
  __typename: "Reminder";
  id: string;
  remindTo: string | null;
  type: string | null;
}

export interface GetAllReminders {
  reminders: (GetAllReminders_reminders | null)[];
}
