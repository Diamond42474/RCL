# RCL

---
#### Description:

RCL (Raspberry Car Lights) is a program that combines RGB lighting with engine diagnostics. 
The program works by a program that runs on a raspberry pi 3 and connects to a OBDII doagnostics tool over Bluetooth. After establishing a connection, the program continually makes calls to
the OBDII tool and grabs the RPM value from the engine. On a seperate thread, the program takes that RPM value and passes it through a function to return values that are then fed 
into a software PWM to control the LEG underglow throughout the interior of the car. Basically, when you go vroom, the lights go !!PARTY TIME!!!
It being in a manual car makes it fun driving at night and knowing exactly what RPM im at based off of the color.

#### Technical

---
##### Electronic Controllers:

[Raspberry Pi 3](https://www.raspberrypi.com/products/raspberry-pi-3-model-b/)

[OBDII](https://en.wikipedia.org/wiki/On-board_diagnostics) (Onboard Diagnostics v2)

##### Audio / Visuals:

12v RGB LED strips
