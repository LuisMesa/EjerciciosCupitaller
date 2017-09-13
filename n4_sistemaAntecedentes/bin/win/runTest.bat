@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n4_sistemaAntecedentes
REM Autor: Rafael Muñoz Lattion - 24-ene-2012
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/sistemaAntecedentes.jar;test/lib/junit.jar;test/lib/sistemaAntecedentesTest.jar junit.swingui.TestRunner uniandes.cupi2.sistemaAntecedentes.test.SistemaAntecedentesTest
	
java -ea -classpath lib/sistemaAntecedentes.jar;test/lib/junit.jar;test/lib/sistemaAntecedentesTest.jar junit.swingui.TestRunner uniandes.cupi2.sistemaAntecedentes.test.ProcesadoTest
	
java -ea -classpath lib/sistemaAntecedentes.jar;test/lib/junit.jar;test/lib/sistemaAntecedentesTest.jar junit.swingui.TestRunner uniandes.cupi2.sistemaAntecedentes.test.AntecedenteTest
cd bin/win