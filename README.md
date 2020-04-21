# CurrencyApp
 
This app uses following components:

Dagger2

MVVM Architecture

Room Database

RXJava/Android

Mockito for test

UI layer is extracted into 3 parts:
Fragment: Its role is to register listener and pass events to corresponding views.

Implementation: This is the veiw where Inflation and rendering of view happens.There is no chain of dependencies from Fragment to FragmentImpl.This allows us to demostrate Dependency Inversion Principle of SOLID principle.This allows to swap different implementations of SpecificViewMvc very easily, which can be extremely beneficial (e.g. AB testing of different implementations of a screen) and makes it more readable.

View: Interface which contains Listeners and common methods for view.

Usecase: This class will segragate out all web service relaled calls to have clean architecture.

Design Patterns Used:
Observable design pattern: This is used heavily for any events. Fragments will recieve events only if it is registered. This is achieved with BaseView, ObservableView and BaseObservable classes.

Factory design pattern: Fragment creation happens at runtime based on the classname passed. This is done through ViewFactory class.

Repository:
    App uses shopping repository as single point of truth for webservice and database 
    management(ShoppingRepository class)
RX:
   RX is used for multithrading for POST, GET, DELETE and GET. 
   This is used in combination with Retrofit.(ShoppingService.class)
Dagger 2:
   App uses Dagger2 as dependency library. This is done to reduce boilerplate code. 
   This has been acheived through seprating it 
   into component, module.
Unit Test:
 Unit test has been added for UI component. If we decide to have more screens we can use same UI test structures and hierarchy.
