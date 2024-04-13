# Assignment Deadline Assistant Manager (ADAM) Part 1 #

This is document version 2024-03-15.

You may customize the `<STYLE>` part of the document for your
preferences with a markdown viewer. `IntelliJ` can export it to
another format using
`Tools > Markdown Converter > Export Markdown File To...`
Use the `Microsoft Word` format if you want more control over line
wrapping and paragraph formatting generally.

Export to PDF requires you to have the rendered markdown being shown
in IntelliJ, whether that is the split source/rendered view or just
the rendered version. Alternatively use `pandoc` to convert it to
another format.

# Contents #

* [About this assignment](#about-this-assignment-)
* [Key points](#key-points-)
* [ADAM's functionality](#adams-functionality-)
* [Basic functionality requirements](#basic-functionality-requirements-)
* [The TODO list](#the-todo-list-)
* [Designing the application](#designing-the-application-)
* [Freedom is part of the assignment](#freedom-is-part-of-the-assignment-)
* [Rules](#rules-)
  * [Your submission MUST](#your-submission-must-)
  * [Your submission MUST NOT](#your-submission-must-not-)
  * [Your submission MAY](#your-submission-may-)
  * [You MAY](#you-may-)
  * [Working together](#working-together-)

# About this assignment #

This entire assignment (Parts 1 and 2) is about designing, building,
and testing a basic application for helping manage assignment
deadlines and plan workloads. The application is called ADAM which
stands for "ADAM's a Deadline Assignment Manager." The name is a
recursive acronym, which is a classic naming technique in Computer
Science.

This Assignment is in two Parts: the first formative and the second
summative. You will extend and complete the application for Part 2 but
in Part 1 you will implement basic functionality then migrate that
basic functionality into an overall design for the application. The
Assignment is designed this way to make it more manageable for those
with limited experience writing full applications. Experienced
programmers can go about the Assignment however you wish. You are
encouraged to use some of the weeks between Part 1 and Part 2 to
refine your design and implementation because you will be reusing it
in Part 2.

Things to do for Part 1:

1.  Consider installing the `Better Highlights` plugin to show method
    complexity.
2.  Consider installing the `TODO Exporter` plugin if you want to view
    all the `TODO` comments in the source code in a separate file
    (though sometimes some TODOs might be missed). 
3.  Design and implement core functionality in the various `src/todo*`
    packages (you can do this concurrently with the next item).
4.  Design and implement the application in the `src/application`
    package.
5.  Delete the TODO comments and explanatory comments in the source
    code so that **your** code and comments are easier for your tutor
    to see. Please do this. Annoying your marker is not a good tactic.

If you complete this assignment you will have a basic application that
can read assignment specifications and tell you how much work per day
each assignment needs between a specified starting date and the
deadlines. But it is not a full application because that would take
too long and the complexity would be unnecessarily stressful for
novice programmers — your final year project could be a full
application (complete with documentation) and it takes the years
between now and then to build yourself to that standard. Who knows,
you might even write a sophisticated version of ADAM for your final
year project.

Although there will be gaps in ADAM's functionality, the core
functionality will be there. The purpose of this assignment is not
about trying to write a complete application. It is about learning to
create a program (much) larger than you have written on your degree so
far, and doing so as properly and professionally as you can currently
manage, while pushing yourself to make some improvements. It also
helps you decide how ready you feel for second year Informatics
courses.

[Back to contents](#contents- "Return to the Table of Contents")

# Key points #

1.  You will reuse and extend your Part 1 code and design for Part 2.
    Thus you also have the weeks between Parts 1 and 2 to continue
    working on your assignment if you want. You can do as much or
    little work between the Parts as you wish. The Part 1 submission
    is entirely formative so you should concentrate on the parts that
    you want your tutor to comment on. Use the file
    [`adviseMe.md`](adviseMe.md "The file for specifying what feedback you want")
    to tell to your tutor what you would most like feedback on. Your
    tutor may decide that other parts of your work need the attention:
    trust their judgement. It is not feasible to give feedback on
    everything nor is it necessarily feasible for you to really
    understand and properly implement all the feedback in the
    following few weeks.
2.  Part 2 is the same application but with more requirements, for
    example more range in the input and more information in the
    output.
3.  The
    [official Piazza thread](https://piazza.com/class/lpwh4hs2rz03tf/post/12)
    for this assignment is limited to technical problems and the
    autograder. Don't ask whether you're allowed / supposed to do some
    functionality (eg handle more types of input error) or whether you
    are allowed to use a particular tool or technique (eg regexps or
    static initialisation): just get on with it if you think it'll be
    useful or instructive. The only bans are: lambdas, pipeline
    streams (input and output streams are necessarily allowed), and
    third party libraries.
    Part 2 will tell you what is required in more detail. For now
    don't constrain yourself artificially by coding to a
    specification. It is more valuable to make your Part 1 version
    robust and flexible. Students are encouraged to post and discuss
    other questions on Piazza outside the official A3.1 thread.
    Remember other students are not authorities and may be incorrect.
    There might not be any instructor intervention in these
    discussions, so please use due diligence when using Piazza.
4.  [The basic functionality](#basic-functionality-requirements-)
    of the application is outlined in this document, with further
    details in the separate documents per requirement and in the
    supplied skeleton code.
5.  [The rules](#rules-) for this assignment might differ from what
    you expect and you have much more  
    [freedom in this assignment.](#freedom-is-part-of-the-assignment-)
6.  You are advised to install the plugin `Better Highlights` which
    gives a percentage for how hard a method is for a person to
    understand. This appears one line above a non-trivial method's
    signature. Try to keep each method as "low complexity." The plugin
    is freemium but the free version is sufficient. The recommendation
    to install this plugin is not an endorsement of the plugin.

[Back to contents](#contents- "Return to the Table of Contents")

# ADAM's functionality #

ADAM takes input about one or more assignments (notably the deadline
and how many hours overall work is needed), calculates how much time
remains for each deadline, and outputs how many hours work is needed
per day remaining per deadline. Some aspects of ADAM must be
configurable, for example how to display the output. Thus ADAM will
also have to read configuration information that is independent of the
assignment information. To facilitate testing, it will also be
necessary to tell ADAM what the starting time and date for the
calculations are so that a fixed reference point can be used.

[Back to contents](#contents- "Return to the Table of Contents")

# Basic functionality requirements #

The basic functionality is separate from the task of designing the
application. For Part 1, you set your own rules about designing the
application. However you design the application, the core
functionality is the same. Write basic code to perform the fundamental
operations that ADAM must do otherwise the program will be useless:

1.  **calculate the difference between two dates** &mdash; this is the
    most important feature because without it the program is entirely
    pointless;
2.  create appropriate objects to represent deadlines (calculating the
    difference between dates relies on this);
3.  use times and dates belonging to a particular timezone (default
    Europe/London);
4.  create appropriate objects to represent assignments;
5.  read a configuration file line by line;
6.  read assignment information line by line;
7.  split a line of input into its constituent parts;
8.  normalise pieces of input for consistency;
9.  validate input;
10. act appropriately according to the input;
11. calculate a workload per day from the specified start date (or
    "now") until the assignment deadline;
12. output the daily workload.

These requirements are grouped into "To Do" lists:

| **Task number**       | **To Do number (stage)**        |
|-----------------------|---------------------------------|
| 1  (dates)            | 1 (dates)                       |
| 2  (deadlines)        | 1 (dates)                       |
| 3  (timezones)        | 1 (dates)                       |
| 4  (assignments)      | 2 (assignments)                 |
| 5  (read config)      | 3 (read config)                 |
| 6  (read assignments) | 4 (read assignment)             |
| 7  (split input)      | 5 (process input for syntax)    |
| 8  (normalise input)  | 5 (process input for syntax)    |
| 9  (validate input)   | 6 (process input for semantics) |
| 10 (run actions)      | 6 (process input for semantics) |
| 11 (workload)         | 7 (putting it all together)     |
| 12 (output)           | 7 (putting it all together)     |

: Table: requirements grouped into "To Do" lists.

You can treat each To Do as a mini-assignment or worksheet of up to an
hour each if you need help managing your time. You may tackle them in
any order: the order provided is a reasonable suggestion. It is also
reasonable to start at the end (the "output" task) and go up through
the list. You do not need to complete a To Do before moving on to
another: jump around as seems appropriate, though try not to have too
many items underway at once.

The above To Dos will initially be done in small classes, mostly
separate from the other classes. This is to make the basic
functionality doable by a novice (you should have progressed from
"beginner" by now). This functionality will be done primarily in the
imperative paradigm, that is telling the compiler how to do things,
while (mostly) not using the features that characterise
object-oriented programming. Don't worry, the object-oriented part is
coming in the
[design.](#designing-the-application- "Designing the application")
And if object-oriented design terrifies you, don't worry about that
either because your design can be as object-oriented "light" as you
wish.

[Back to contents](#contents- "Return to the Table of Contents")

# The TODO list #

The tasks you need to do (and one optional task where you have the
chance to be a naughty programmer) are linked from the file
[`todo.md`](todo.md "The assignment TODO list"). It's a separate file
because some students dislike having everything in one file. You can
make your own single-file version if you wish.

[Back to contents](#contents- "Return to the Table of Contents")

# Designing the application #

If you're looking for detailed instructions on designing ADAM, there
aren't any for Part 1. It is important that you try to design it
yourself, perhaps with some help from other students. As you hopefully
saw with the Worksheet Assignment, there is more than one way to
design even a fairly simple algorithm, so there is much more choice
for a full application. You are strongly advised to have different
designs on paper which you can evaluate before writing any code. Time
is tight for Part 1, so making a reasonable design early is preferable
to making "the perfect" design stressfully close to the deadline.

The good news is you can design ADAM's internals however you wish.
Novices might be constrained by what you are able to do rather than
what you would like to do; if so, don't feel inadequate: your range
improves with practice.

The better news is that you have until the end of Part 2 to refine
your design. So don't pressure yourself too much for Part 1. Of
course, the more you do before Part 2, the more prepared you will be
for Part 2 when the requirements are extended. But remember to work
smart rather than work hard. Remember to apply what you learned from
the Worksheet Assignment and code a design rather than making it up as
you go along coding.

> Weeks of coding can save you hours of planning.

Quote provided by Altu Bozyaka, currently taking Inf1B.

A tip from a Software Engineering PhD student:

> Java is English, so if a design can be written in English, it can be
> written in Java.

Perhaps the best news is that Part 2 is entirely automarked and the
automarker does not care how awful your design is or how ugly your
program code is. (This also means it does not appreciate your elegant
design and beautiful code.)  Basically, as long as your submission
works as expected and produces the correct output for the given input,
it will pass. More on the Part 2 autograder in Part 2. Part 1 has just
a basic autograder because the focus is on designing and discussing
the design. For Part 1 I want you to concentrate on the aspects of the
assignment that you feel you most need. That's why it is formative.
Don't stress about Part 1's lack of tests to pass: focus on testing
your own design.

You can also keep working on ADAM after the course finishes if you
wish. This would be great preparation for those taking the August
Assessment and for everyone taking second year Informatics courses.

[Back to contents](#contents- "Return to the Table of Contents")

# Freedom is part of the assignment #

There is considerable range in experience and skill across all the
students taking this course, so being overly prescriptive will be good
for some yet annoyingly restrictive for others. Thus you are allowed
to make your program as fancy as you can or as basic as you need. If
you want it to handle additional situations then that is fine and you
don't need to ask permission, just do it.

Do not worry about this freedom: embrace it. Part 1 is formative and
your tutor can give you feedback on your design, as may lab
demonstrators and other students. See [the rules](#rules-) for more
information.

[Back to contents](#contents- "Return to the Table of Contents")

# Rules #

This assignment is testing your ability to apply knowledge and to
think about what needs doing and how to do it. Thus there will be an
official Piazza thread only for technical problems and the autograder
but not for answering questions on how you should do the assignment.
How you do the assignment is up to you: deciding that is part of the
assignment. You can post Piazza questions for clarifications but these
will be answered by other students, so the answers are not
authoritative.

We are using engineering requirements to specify the rules. There was
a comment in the mid-course feedback that engineering requirements are
a weird way to specify things and why not just use proper paragraphs.
Engineering requirements are more verbose than a paragraph but they
are clearer and less prone to misinterpretation. They also remove the
skill needed to identify requirements in prose. You will learn about
that in future Software Engineering courses.

Engineering requirements also provide a useful checklist because you
can show whether each requirement has been met. This feature can be
useful for other assignments.

## Your submission MUST ##

1.  compile and run in OpenJDK 17 (seventeen) because that is the
    latest JDK supported by the autograder;
2.  retain the original project structure and naming as provided;
3.  use only the libraries provided with JDK and any you write
    yourself;
4.  be a single zip file of the project as produced by IntelliJ.

## Your submission MUST NOT ##

1.  use third party libraries, that is libraries that are not part of
    JDK, for example libraries by Apache or Google or taken from public
    repositories like GitHub;
2.  use lambdas, higher order functions, passing classes or methods as
    parameters, or stream pipelines (input and output streams are
    necessarily allowed); not because these are "bad" but because they
    belong to the functional paradigm, and this course is about the
    object-oriented and imperative paradigms.

## Your submission MAY ##

1.  add extra functionality, additional checks, or more robustness (for
    example handling rogue input) beyond what is in the Part 1
    instructions.

## You MAY ##

1. discuss your Part 1 design with your tutor;
2. discuss your Part 1 design with the lab demonstrators;
3. discuss your Part 1 design with other students;
4. share code snippets with other students (for Part 1).

[Back to contents](#contents- "Return to the Table of Contents")

## Working together ##

See the ["You MAY" requirement](#you-may-).

For the avoidance of doubt: you are allowed to discuss designs with
other students. You may share ideas and snippets of code. We want you
to put knowledge from the course into practice.

If you do not make enough effort to understand the design and code you
submit for Part 1, then you will likely have serious difficulties when
you have to change the design and code for Part 2. So, if you feel you
have to rely heavily on help to attempt Part 1, then spend some of the
time between Parts 1 and 2 understanding what you submitted by trying
to add more functionality or more variation in the input.

For Part 1 you are probably better submitting a simpler design that
you feel comfortable with even if it is not high quality. Each student
has different experience and needs and this assignment is giving you
the freedom.

[Back to contents](#contents- "Return to the Table of Contents")
