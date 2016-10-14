#Installation

## System requirements


## How to import and configure the library in your java project

In order to import the Dr. Inventor Text Mining Framework in your java project you have to perform the following two steps:

### STEP 1: Import the library
There are two ways to import the library:
1. If you are using Maven, add to the POM of your Maven project the following repository:
```javascript
<repositories>
	<repository>
		<id>backingdata-repo</id>
		<name>Backingdata repository</name>
		<url>http://backingdata.org/dri/library/mavenRepo/</url>
	</repository>
</repositories>
```
and the following dependency:
```javascript
<dependency>
	<groupId>edu.upf.taln.dri</groupId>
	<artifactId>lib</artifactId>
	<version>2.1</version>
</dependency>
```

2. If you want to import directly the dependency of the library in your java code, download the JAR / dependencies at the following link: jar of the library together the libraries it depends on (lib folder).

### STEP 2: Configure the library
once imported the library and its dependences, the following step should be carried out:
1. Download and extract Dr. Inventor Library Resources directory in $DRI_RESOURCE_DIR_PATH
2. Download Dr. Inventor Library Property file as $DRI_PROPERTY_FILE_PATH
3. when executing a java program that imports and uses the Dr. Inventor Library, set the following virtual machine arguments:
   * -DDRIpropertyFile=$DRI_PROPERTY_FILE_PATH (mandatory): local absolute path to Dr. Inventor Library property file. It is possible to download this file locally here. Once downloaded, it is needed edit the local copy of the Dr. Inventor Library property file by setting the property "resourceFolder.fullPath" equal to the Dr. Inventor Library Resources directory local path (without trailing slash, for instance: /home/mydir/DRIresources-2.1).
   * -Xmx4500m (optional): maximum Java Heap (>= 4,5Gb)
 
## Execution requirements
* Java 1.8
* Define the maximum Java Heap Space equal or greater than 4,5Gb (by means of Virtual Machine arguments - -Xmx4500m - or by means of system properties)

## Update to a new version
IMPORTANT: When updating from an older version of the library to the version 2.1, please, remember to:
If the library is imported by Maven, update your project Maven POM with then new library version number
If the JAR of the library is directly imported, Download the new JAR files of the library together with its dependencies
Download the new Dr. Inventor Library Resources directory
Download the new Dr. Inventor Library Property file. Replace this file to the old Dr. Inventor Library Property file if any. Modify the contents of this file by specifying the local path of the new Dr Inventor Library Resources directory
