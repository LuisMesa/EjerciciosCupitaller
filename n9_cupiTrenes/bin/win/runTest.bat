@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n9_cupiTrenes
REM Autor: Vanessa Pérez Romanello - 07-oct-2011
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/cupiTrenes.jar;test/lib/junit.jar;test/lib/cupiTrenesTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTrenes.test.CupiTrenesTest
	
java -ea -classpath lib/cupiTrenes.jar;test/lib/junit.jar;test/lib/cupiTrenesTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTrenes.test.ViajeTest
	
java -ea -classpath lib/cupiTrenes.jar;test/lib/junit.jar;test/lib/cupiTrenesTest.jar junit.swingui.TestRunner uniandes.cupi2.cupiTrenes.test.VagonTest
cd bin/win