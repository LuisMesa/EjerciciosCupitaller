@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n4_tiendaLibros
REM Autor: Equipo Cupi2 2015
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd../..
java -classpath ./lib/tiendaLibros.jar;./test/lib/tiendaLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.tiendaLibros.test.LibroTest
java -classpath ./lib/tiendaLibros.jar;./test/lib/tiendaLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.tiendaLibros.test.ItemCompraTest
java -classpath ./lib/tiendaLibros.jar;./test/lib/tiendaLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.tiendaLibros.test.CarroComprasTest
java -classpath ./lib/tiendaLibros.jar;./test/lib/tiendaLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.tiendaLibros.test.TiendaLibrosTest

pause