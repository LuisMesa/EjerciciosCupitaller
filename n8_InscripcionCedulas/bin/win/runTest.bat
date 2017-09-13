@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n8_inscripcionCedulas
REM Autor: Equipo Cupi2 2015
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecuci�n de las pruebas
REM ---------------------------------------------------------

cd../..
java -classpath ./lib/inscripcionCedulas.jar;./test/lib/inscripcionCedulasTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inscripcionCedulas.test.InscripcionCedulasTest
java -classpath ./lib/inscripcionCedulas.jar;./test/lib/inscripcionCedulasTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inscripcionCedulas.test.DepartamentoTest
java -classpath ./lib/inscripcionCedulas.jar;./test/lib/inscripcionCedulasTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inscripcionCedulas.test.MunicipioTest
java -classpath ./lib/inscripcionCedulas.jar;./test/lib/inscripcionCedulasTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inscripcionCedulas.test.PuestoVotacionTest
java -classpath ./lib/inscripcionCedulas.jar;./test/lib/inscripcionCedulasTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inscripcionCedulas.test.CiudadanoTest


pause