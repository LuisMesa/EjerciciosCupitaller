@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n6_lucesApagadas
REM Autor: Vanessa P�rez Romanello - 17-ago-2011
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/lucesApagadas.jar;test/lib/junit.jar;test/lib/lucesApagadasTest.jar junit.swingui.TestRunner uniandes.cupi2.lucesApagadas.test.VentanaTest
	
java -ea -classpath lib/lucesApagadas.jar;test/lib/junit.jar;test/lib/lucesApagadasTest.jar junit.swingui.TestRunner uniandes.cupi2.lucesApagadas.test.LucesApagadasTest
cd bin/win