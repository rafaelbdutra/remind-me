const ip = require('ip');
const Eureka = require('eureka-js-client').Eureka;

// example configuration
const client = new Eureka({
    // application instance information
    instance: {
        app: 'remind-me-gateway',
        hostName: 'localhost',
        ipAddr: ip.address(),
        port: {
            '$': 3000,
            '@enabled': true
        },
        vipAddress: 'remind-me-gateway',
        statusPageUrl: 'http://localhost:3000/info',
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn',
        },
        registerWithEureka: true,
        fetchRegistry: true,
    },
    eureka: {
        // eureka server host / port
        host: ip.address(),
        port: 8761,
        servicePath: '/eureka/apps'
    },
});

connect = () => {
    client.logger.level('debug');
    console.log('Connecting to Eureka server on http://localhost:8761/eureka/apps');
    client.start();
};

disconnect = () => {
    console.log('Disconnecting Eureka server');
    client.stop();
};

getInstancesByAppId = (appId) => {
    return client.getInstancesByAppId(appId);
};

module.exports.connect = connect;
module.exports.disconnect = disconnect;
module.exports.getInstanceByAddId = getInstancesByAppId;