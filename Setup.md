1. **Setting up the environment**
   
    Install VSCode and JDK17, on PATH.

2. **Setting up our java project**
   
    Install VSCode extension "Extension Pack for Java".

    CTRL+SHIFT+P: "Create Maven Project"
        Group ID: com.planittesting
        Artifact ID: jupitertoys
        Version: default

    This has created a "jupitertoys" directory - let's clean that up by moving the contents (with `pom.xml`) into the
    base directory.

    Our directory structure should look like this:
        Base directory:
            pom.xml
            src/
                main/...    // Delete this
                test/...

    Delete the "src/main" directory.

    Now, let's modify the directory structure to look like this:
        Base directory:
            pom.xml
            src/test/java/com/planittesting/jupitertoys/tests/  // Place AppTest.java in here for now

    Now, if we have Java and VSCode configured correctly, we should be able to run the default test in `src/test/java/com/planittesting/AppTest.java`
        ! Stop and ask for help if you can't run the default test !

3. **Fixing the Java version**

    The Maven project may not be on the correct Java version.

    In `pom.xml`, delete the `<properties>` tag and all contents.

    Then, add the following to `maven-compiler-plugin` under `<plugins>`:
    ```
        <configuration>
            <release>17</release>
        </configuration>
    ```

4. **Installing dependencies**

    Open `pom.xml`. There should be a `<dependencies>` tag. Remove everything inside `<dependencies>`.

    Let's go to mvnrepository.com and install the following dependencies
    (by copying the provided XML into `<dependencies>`):
         - JUnit Platform Launcher
         - Junit Jupiter (Aggregator)
         - Selenium Java

    (Get the latest version each time.)
    (After pasting the imports in, do CTRL+SHIFT+P and select "Format Document" to fix the XML indentation). 

    Our test will no longer run because the imports are wrong - delete the imports and use CTRL+. to fix the imports,
    then check that the default test still runs.

5. **Installing drivers.**
   
    Selenium requires drivers to interact with a given browser.
    You have the choice of Chrome or Firefox (although I recommend Chrome for this bootcamp).

    **Windows**

    For Chrome, determine your Chrome version (Setting -> About Chrome) and download the corresponding version of
    chromedriver: https://chromedriver.chromium.org/downloads

    For Firefox, download geckodriver: https://github.com/mozilla/geckodriver/releases

    Place the driver in a simple path like `C:/selenium/`. Then, add this directory to your path (search for
    "edit the system environment variables" in the start menu and edit PATH for your local user).

    **Linux & Mac**

    You can download from the official source or use a package manager. You may want to google some instructions for
    your system. If downloaded from the official source, you'll need to modify the `PATH` environment variable for 
    the driver to be found by Selenium.