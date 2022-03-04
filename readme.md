# Store

A simple Model-View-Controller (MVC) Java-based demonstration.
I use it to explain MVC to developers.

## What's Inside?

+ A model: Category entity/model, CategoryRepository
+ A controller: CategoryController
+ A request router: Router
+ Some views: creation view, single search view (search by id), multiple search view (search by term), deletion view

## How it Works

1. The main method (application entrypoint) creates a SQL connexion and runs a loop to read user requests
   _(See the anatomy of a request later on)_
2. The main method initializes the route and, for each request, calls the router to accept request infos
3. The router reads the path and:
   1. determines which controller should handle the request
   2. parses the request data
   3. calls the appropriate controller method
   4. creates a view with data from the controller route handler and renders the view

Anatomy of user request:

+ User request is read multiple lines at a time
+ A blank line indicate user is done with request input
+ First line of the request if the path (think of it that the action the user wants to perform)
+ Subsequent non-blank lines are key-value pair (one per line), which are data embedded in the request

e.g:
```text
/students/create
firstname=Quellchrist
lastname=Falconner
birthday=1987/03/17

```

In the above request example:

+ `/students/create` is the path
+ `Quellchrist` is the value of the field `firstname`
+ `Falconner` is the value of the field `lastname`
+ `1987/03/17` is the value of the field `birthday`
+ and because the user entered a blank line at the end, we know that is the end of that request

# Getting started

Make sure you have java, javac on your classpath.

Download MySQL JDBC driver.

+ Start your MySQL Server
+ Either (1) make sure you can log into it as `root` without password or (2) change the `main` method with you database credentials
+ Either (1) create a `store` database or (2) change the `main` method with you database name
+ Run the SQL commands commented right above the `main` method, to create necessary tables

Then:
```shell
# Clone this repository
$ git clone https://github.com/Salathielgenese/store.git
# Move into the project root
$ cd store/
# Compile the sources (all .java files under src/) using Mysql JDBC driver, and output .class files into out/
~/store$ javac -d out -cp path/to/mysql-connector-java-8.0.28.jar $(find src -type f -name '*.java')
# Run the application (compiled files), also using MySQL JDBC driver
~/store$ java -cp path/to/mysql-connector-java-8.0.28.jar:out name.genese.salathiel.store.Main
```

**NOTE:** Note that the `find` command above is available on *nix operating systems (so it won't work on Windows out of the box).

**NOTE:** If you are using your IDE, please refer to its specific documentation to add a library and run it from you editor.

## What's Next?

+ Explore the code to understand
+ Change stuffs to see how it behaves
+ Add some features to the app, like product and even the relationship one-to-many between product and category

## Got Questions? Critics? Suggestions?

Open an issue on this repository.

## Example Output

```text
/categories

SEARCH RESULTS
    - Category{ id=3, name='fries' }
    - Category{ id=1, name='sauces' }
    - Category{ id=2, name='spices' }

/categories/update
id=1
name=saucage

UPDATE RESULT
    - Category{ id=1, name='saucage' }

/categories

SEARCH RESULTS
    - Category{ id=3, name='fries' }
    - Category{ id=1, name='saucage' }
    - Category{ id=2, name='spices' }

/categories/delete
id=1

DELETION RESULT
    <success>

/categories/create
name=sauces

CREATION RESULT
    - Category{ id=4, name='sauces' }

/categories

SEARCH RESULTS
    - Category{ id=3, name='fries' }
    - Category{ id=4, name='sauces' }
    - Category{ id=2, name='spices' }

/categories
terms=c

SEARCH RESULTS
    - Category{ id=4, name='sauces' }
    - Category{ id=2, name='spices' }

/categories
terms=i

SEARCH RESULTS
    - Category{ id=3, name='fries' }
    - Category{ id=2, name='spices' }
```
