const { getAllReminders, getReminder } = require('../query/reminder-query');

module.exports.resolvers = {
    Query: {
        reminders: () => getAllReminders().then((res) => res.body),
        reminder: (parent, args, context, info) => getReminder(args.id).then((res) => res.body),
    },
};