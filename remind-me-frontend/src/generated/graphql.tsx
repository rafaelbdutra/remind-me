import gql from "graphql-tag";
export type Maybe<T> = T | null;
/** All built-in and custom scalars, mapped to their actual values */
export type Scalars = {
  ID: string;
  String: string;
  Boolean: boolean;
  Int: number;
  Float: number;
  /** The `Upload` scalar type represents a file upload. */
  Upload: any;
};

export enum CacheControlScope {
  Public = "PUBLIC",
  Private = "PRIVATE"
}

export type Query = {
  __typename?: "Query";
  reminders?: Maybe<Array<Maybe<Reminder>>>;
  reminder?: Maybe<Reminder>;
};

export type QueryReminderArgs = {
  id: Scalars["ID"];
};

export type Reminder = {
  __typename?: "Reminder";
  id: Scalars["ID"];
  remindTo?: Maybe<Scalars["String"]>;
  type?: Maybe<Scalars["String"]>;
};

export type Unnamed_1_QueryVariables = {};

export type Unnamed_1_Query = { __typename?: "Query" } & {
  reminders: Maybe<
    Array<
      Maybe<
        { __typename?: "Reminder" } & Pick<Reminder, "id" | "remindTo" | "type">
      >
    >
  >;
};
