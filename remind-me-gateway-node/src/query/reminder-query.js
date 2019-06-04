const got = require('got');
const eureka = require('../eureka/eureka');

getAllReminders = () => {
    const baseUrl = `http://${getQueryUrl()}`;
    const uri = '/query/reminders';
    const options = {
        json: true,
        baseUrl: baseUrl,
    };

    return got(uri, options);
};

getReminder = (id) => {
    const baseUrl = `http://${getQueryUrl()}`;
    const uri = `/query/reminders/${id}`;
    const options = {
        json: true,
        baseUrl: baseUrl,
    };

    return got(uri, options);
};

getQueryUrl = () => {
    const instance = eureka.getInstanceByAddId('REMIND-ME-QUERY');
    return instance.map((i) => `${i.ipAddr}:${i.port.$}`)[0];
};

module.exports.getAllReminders = getAllReminders;
module.exports.getReminder = getReminder;