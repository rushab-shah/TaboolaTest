CREATE TABLE PRODUCTS (
     productName VARCHAR(255) NOT NULL,
     productCategory VARCHAR(255) NOT NULL,
     PRIMARY KEY (productName)
);

CREATE TABLE PRICE_HISTORY (
     productName VARCHAR(255) NOT NULL,
     startDate VARCHAR(255) NOT NULL,
     endDate VARCHAR(255),
     price INT NOT NULL,
     FOREIGN KEY (productName) REFERENCES PRODUCTS(productName)
);

INSERT INTO PRODUCTS VALUES ('Car', '4W');
INSERT INTO PRODUCTS VALUES ('Bike', '2W');
INSERT INTO PRODUCTS VALUES ('Phone', 'Tech');

INSERT INTO PRICE_HISTORY VALUES ('Car', 'st','ed',1000);
INSERT INTO PRICE_HISTORY VALUES ('Bike', 'st',NULL,2000);
INSERT INTO PRICE_HISTORY VALUES ('Phone', 'st','ed',1000);

SELECT P.productName, P.productCategory, H.price, H.startDate, H.endDate
from PRODUCTS P
INNER JOIN PRICE_HISTORY H
ON P.productName = H.productName;
