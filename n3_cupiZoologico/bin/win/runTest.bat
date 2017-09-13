@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n3_cupiZoologico
REM Autor: Equipo cupi2 2015
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecuci�n de las pruebas
REM ---------------------------------------------------------

cd ../..

java -ea -classpath ./lib/cupiZoologico.jar;./test/lib/cupiZoologicoTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiZoologico.test.AnimalTest
java -ea -classpath ./lib/cupiZoologico.jar;./test/lib/cupiZoologicoTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiZoologico.test.GuardiaTest
java -ea -classpath ./lib/cupiZoologico.jar;./test/lib/cupiZoologicoTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiZoologico.test.JaulaTest
java -ea -classpath ./lib/cupiZoologico.jar;./test/lib/cupiZoologicoTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiZoologico.test.ZoologicoTest

