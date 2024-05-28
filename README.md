# My Personal Project

## A cookbook application

<h1>Cookbook Project </h1>

<p> My project is a cookbook which keeps track of recipes for people for convenience. 
My recipe class will have  the following </p>
<ul>
  <li>recipe name</li>
  <li>author</li>
  <li>ingredients</li>
  <li>equipment</li>
  <li>steps required</li>
  <li>time required</li>
  <li>rating</li>
</ul>. 
<p> The cookbook class will be a list of recipes which people can look through to find the 
recipe they desire. </p>

People who cook at home are the main target audience. This will make it easier to store recipes and search for
them much easier than on paper (which can be lost or damaged beyond legibility). This project is of interest to me
as I **love** to cook at home and always wanted a better way to track my recipes. 

A *bulleted* list for console application:
- As a user, I want to be able to store multiple recipes in a cookbook
- As a user, I want to be able to view a list of recipes in my cookbook
- As a user, I want to be able to add recipes into my cookbook
- As a user, I want to be able to rate the recipes on a scale of 1-5
- As a user, I want to be able to delete recipes from my cookbook
- As a user, I want to be able to save my recipe list to file (if I so choose)
- As a user, I want to be able to reload my recipe list from file (if I so choose)

A *bulleted* list for GUI application:
- As a user, I want to be able to view all recipes added to a cookbook
- As a user, I want to be able to add multiple recipes to a cookbook
- As a user, I want to be able to remove multiple recipes from a cookbook
- As a user, I want to be able to save my recipes if I so choose (button)
- As a user, I want to be able to load my recipes if I so choose (button)

# Phase 4 Task 2

- Each time you add a recipe, it will be logged and printed when you close the window
- Each time you remove a recipe, it will be logged and printed when you close the window
- Each time you view your cookbook, it will be logged and printed when you close the window

- Fri Dec 01 12:43:01 PST 2023: added recipe '1'
- Fri Dec 01 12:43:09 PST 2023: added recipe '2'
- Fri Dec 01 12:43:12 PST 2023: viewed recipes
- Fri Dec 01 12:43:16 PST 2023: removed recipe '1'
- Fri Dec 01 12:43:18 PST 2023: removed recipe '2'


# Phase 4 Task 3

In my project, there were some instances where I could improve the code. For instance, before we learned about the 
singleton pattern, I implemented a single class with a single Cookbook field. It would be a better design choice to
implement the singleton pattern into my Cookbook class as I only ever use one cookbook. Therefore, if I had more time,
I would remove the CookbookState class and make the Cookbook class a singleton pattern to ensure that I am only ever 
using one instance of a class and for cleaner and easier to understand code.

As well, I have a lot of repeated methods in my classes. If I had more time, I would abstract some of these methods to
improve the cleanliness of my code and the redundancy of my code. 

I could also use hashmaps to create a 







