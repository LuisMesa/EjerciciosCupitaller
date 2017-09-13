#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n2_empresa
# Autor: Equipo Cupi2 2015
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecución de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/empresa.jar:./test/lib/empresaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner co.edu.uniandes.cupi2.empresa.test.EmpleadoTest
java -ea -classpath ./lib/empresa.jar:./test/lib/empresaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner co.edu.uniandes.cupi2.empresa.test.EmpresaTest
cd bin/mac

stty echo
