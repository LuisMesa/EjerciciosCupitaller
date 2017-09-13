#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n8_inscripcionCedulas
# Autor: Equipo Cupi2 2015
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
java -ea -classpath ./lib/inscripcionCedulas.jar:./test/lib/inscripcionCedulasTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inscripcionCedulas.test.InscripcionCedulasTest
java -ea -classpath ./lib/inscripcionCedulas.jar:./test/lib/inscripcionCedulasTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inscripcionCedulas.test.DepartamentoTest
java -ea -classpath ./lib/inscripcionCedulas.jar:./test/lib/inscripcionCedulasTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inscripcionCedulas.test.MunicipioTest
java -ea -classpath ./lib/inscripcionCedulas.jar:./test/lib/inscripcionCedulasTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inscripcionCedulas.test.PuestoVotacionTest
java -ea -classpath ./lib/inscripcionCedulas.jar:./test/lib/inscripcionCedulasTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inscripcionCedulas.test.CiudadanoTest
cd bin/mac

stty echo