# Led Matrix on Raspberry Pi with java

LedMatrix is a library to manage a simple led matrix using gpio of a Raspberry Pi.

## The matrix
This library is meant to drive led matrix using shift registers to address columns and a decade counter for scanning lines.
So we can manage up to 10 lines and a multiple of 8 columns.
Instructions to build such matrix can be found easily, for example [here](http://www.instructables.com/id/Make-a-24X6-LED-matrix/)

It require five GPIO pins:
* 3 for the shift registers
    * 'ShiftData' default is GPIO01
    * 'ShiftClock' default is GPIO02
    * 'ShiftLatch' default is GPIO03
* 2 for the decade counter
    * 'CounterClock' default is GPIO04
    * 'CounterReset' default is GPIO05

As we rely on the awesome [Pi4j](http://pi4j.com) we follow the same pin numbering schema, which is the same as wiringpi. 
Details can be found in documentation of [Pi4j](http://pi4j.com/usage.html#Pin_Numbering) and [wiringpi](http://wiringpi.com/pins/).

## Installation
LedMatrix is provided as a maven dependency. You'll need to add Crafting Labs repo to your pom:


    <repositories>
        <repository>
            <id>crafting-labs-repo</id>
            <name>Crafting Labs maven repository</name>
            <url>http://maven.crafting-labs.fr/</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>

The following dependency is all you need to use ledmatrix4j:
    
    <dependencies>
        <dependency>
            <groupId>fr.craftinglabs.pi</groupId>
            <artifactId>ledmatrix</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    </dependencies>

note that currently, there is only a SNAPSHOT version available. A 0.1 release should come soon.

## Usage
### Initialize the matrix

If you followed the default wiring (see above) for your matrix, then it's quite easy

    Matrix matrix = new Matrix(new Size(32, 10));
    
    
Otherwise, you'll have to first built a MatrixGPIO object with the correct pin.
For example:
    
    MatrixIO matrixIO = new MatrixGPIO(RaspiPin.GPIO_01, RaspiPin.GPIO_02, RaspiPin.GPIO_03, RaspiPin.GPIO_04, RaspiPin.GPIO_05);
    
Then give it to Matrix constructor:
  
    Matrix matrix = new Matrix(new Size(8, 6), matrixIO);
    
### Print things on the matrix

Once you matrix is initialized, you can asked it to print things. Matrix can print Frame.
A Frame is a representation of the what can be print on the matrix. It should have the same size than the matrix.

    Frame checkeredFrame = new Frame("01010101",
                                     "10101010",
                                     "01010101",
                                     "10101010",
                                     "01010101",
                                     "10101010");
                                     
A '0' means the led is off while a '1' means the led is on.                          
Note: I don't like that way, it will probably change in a close future.

Then, you can print it.

    matrix.print(100, checkeredFrame);
    
The first parameter of the 'print' method define how many time the frame will be displayed. The bigger, the longer.

On that kind of matrix, there is only one line light up at a given time. The fact that we see them all is an optical trick due to the line switching fast enough.
On a raspberry pi 2 that does nothing else, there are around 30000 lines printed per second.

The 'print' can also take an 'Iterable<Frame>' as argument (instead of the Frame), this is more convenient to build animation. See ['SlidingGlyphs'](ledmatrix/src/main/java/fr/craftinglabs/pi/matrix/frame/SlidingGlyphs.java) and ['SlidingHelloWorldExample'](ledmatrix-examples/src/main/java/fr/craftinglabs/pi/matrix/examples/SlidingHelloWorldExample.java).


## Caution

* This is a work in progress, you can expect everything above MatrixIO to change radically in the next few days/weeks :)
* This rely on Pi4j 1.1-SNAPSHOT, so not an official release that may change too.

## Licence
The MIT License (MIT)

Copyright (c) 2016 Antoine Vernois

See [LICENCE](LICENCE)