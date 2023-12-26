CREATE TABLE cars (
      id INT PRIMARY KEY AUTO_INCREMENT,
      brand VARCHAR(25),
      origin VARCHAR(25)
);
CREATE TABLE thefts (
      id INT PRIMARY KEY AUTO_INCREMENT,
      car_rank VARCHAR(25),
      model VARCHAR(25),
      state VARCHAR(25),
      thefts_num VARCHAR(25),
      year VARCHAR(25),
);

LOAD DATA INFILE '/path/cars.csv'
INTO TABLE cars
FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

LOAD DATA INFILE '/path/2015_State_Top10Report_wTotalThefts.csv'
INTO TABLE thefts
FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n'
IGNORE 1 ROWS;


UPDATE thefts t
    JOIN cars c
    ON t.model
    LIKE CONCAT('%', c.brand, '%')
    SET t.car_id = c.car_id
    WHERE t.id > 0;
