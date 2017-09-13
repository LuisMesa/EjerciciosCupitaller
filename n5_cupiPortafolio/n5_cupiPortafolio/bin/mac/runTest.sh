#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n5_cupiPortafolio
# Autor: Equipo Cupi2 2015
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecución de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/cupiPortafolio.jar:./test/lib/cupiPortafolioTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiPortafolio.test.EstudianteTest
java -ea -classpath ./lib/cupiPortafolio.jar:./test/lib/cupiPortafolioTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.cupiPortafolio.test.PortafolioEstudiantilTest
cd bin/mac

stty echo
