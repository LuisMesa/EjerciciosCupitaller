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
REM Asegura la creaci�n del directorio docs/api
REM ---------------------------------------------------------

cd ../../docs
mkdir api
cd ../bin/win

REM ---------------------------------------------------------
REM Genera la documentaci�n
REM ---------------------------------------------------------

javadoc -sourcepath ../../source -d ../../docs/api -subpackages uniandes.cupi2.lucesApagadas