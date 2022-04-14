CREATE TABLE IF NOT EXISTS USER(
    account varchar(30) NOT NULL primary key,
    firstName varchar(30) NULL,
    lastName varchar(30) NULL,
    phone varchar(30) NULL,
    password varchar(30) NULL,
    role varchar(30) NULL,
    credit int NULL,
    rating int NULL,
    tax varchar(30) NULL,
    license varchar(30) NULL,
    experience int NULL,
    assignDrone int NULL,
    StoreName varchar(30) NULL
);

CREATE TABLE IF NOT EXISTS Item(
    unitPrice int NULL,
    itemName varchar(30) NOT NULL,
    storeName varchar(30) NOT NULL,
    weight int NULL,
    primary key(itemName, storeName)
);

CREATE TABLE IF NOT EXISTS Line(
    quantity int NULL,
    unitPrice int NULL,
    itemName varchar(30) NOT NULL,
    orderId varchar(30) NOT NULL,
    weight int NULL,
    primary key(itemName, orderId)
);

CREATE TABLE IF NOT EXISTS Store(
    revenue int NULL,
    storeName varchar(30) primary key
);

CREATE TABLE IF NOT EXISTS Drone(
    droneId int AUTO_INCREMENT primary key,
    storeName varchar(30),
    capacity int NULL,
    leftTrip int NULL,
    pilotAccount varchar(30) NULL
);

CREATE TABLE IF NOT EXISTS Order_Table(
    orderId varchar(30) AUTO_INCREMENT primary key,
    droneId int NULL,
    totalPrice int NULL,
    pilotAccount varchar(30),
    customerAccount varchar(30),
    storeName varchar(30),
    totalWeight int NULL,
    createTime Timestamp NULL,
    payTime Timestamp NULL,
    orderStatus varchar(30) NULL
);