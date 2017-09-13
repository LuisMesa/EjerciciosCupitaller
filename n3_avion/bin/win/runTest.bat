@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM $Id$
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación
REM Licenciado bajo el esquema Academic Free License version 2.1
REM
REM Proyecto Cupi2
REM Ejercicio: n3_avion
REM Autor: Equipo Cupi2 2015
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------
cd ../..
java -classpath ./lib/avion.jar;./test/lib/avionTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.avion.test.AvionTest
java -classpath ./lib/avion.jar;./test/lib/avionTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.avion.test.EquipajeTest
java -classpath ./lib/avion.jar;./test/lib/avionTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.avion.test.PasajeroTest
