@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n5_cupiPortafolio
REM Autor: Equipo Cupi2 2015
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd../..
java -classpath ./lib/cupiPortafolio.jar;./test/lib/cupiPortafolioTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiPortafolio.test.EstudianteTest
java -classpath ./lib/cupiPortafolio.jar;./test/lib/cupiPortafolioTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiPortafolio.test.PortafolioEstudiantilTest
