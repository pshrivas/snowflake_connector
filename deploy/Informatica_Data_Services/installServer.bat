@echo off
REM SnowflakeV2 connector - server install script
IF /I "%~1" == "" goto displayUsage

IF /I "%~1" == "help" goto displayUsage


SET INFA_HOME=%~1
IF NOT EXIST "%INFA_HOME%" goto incorrectDir

SET UPGRADE=false
IF /I NOT "%~2" == "" SET UPGRADE=%~2
if /I defined UPGRADE ( if /I not "%UPGRADE%"=="true" ( if /I not "%UPGRADE%"=="false" goto incorrectUpgradeValue))

robocopy "server" %INFA_HOME% /E /LOG:serverCopy.log >nul
IF %ERRORLEVEL% GTR 7 EXIT /B -%ERRORLEVEL%
robocopy "server/plugins/dynamic" "%INFA_HOME%/isp/bin/plugins/oie/eclipse/plugins" /E /LOG:serverIoeCopy.log >nul
IF %ERRORLEVEL% GTR 7 EXIT /B -%ERRORLEVEL%

SET JAVA_HOME=%INFA_HOME%/java
SET PATH=%INFA_HOME%/isp/bin;%JAVA_HOME%/bin;%PATH%

SET SKIPREGISTER=false
IF /I NOT "%~3" == "" SET SKIPREGISTER=%~3
if /I not "%SKIPREGISTER%"=="true" ( if /I not "%SKIPREGISTER%"=="false" goto invalidOption )
if /I not "%SKIPREGISTER%"=="true" infasetup validateAndRegisterFeature -ff "%INFA_HOME%/plugins/conf/unicosolution.snowflakev2.xml" -up %upgrade%	
goto end

:displayUsage

echo Usage: installServer ^<infa_server_home^>  [^<upgrade^>] [^<skipregistration^>]
echo          infa_server_home  - this is the root directory for the server installation.
echo		  upgrade - this should be "true" if you want to re-install an connector else false.
echo 		  skipregistration - this option should be true if you wants to skip validateAndRegister command for connector installation else false.
goto end

:incorrectDir
echo %INFA_HOME% is not a valid directory
goto displayUsage

:incorrectUpgradeValue
echo Incorrect Usage. Valid values for upgrade are "true" and "false"
goto displayUsage

:invalidOption
echo Incorrect Usage.
goto displayUsage

:end
if "%OS%" == "Windows_NT" endlocal