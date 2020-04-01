// alert("hello");

const todos = [
  {
    id: 1,
    text: "hello",
    isCompleted: true
  },
  {
    id: 2,
    text: "hello2",
    isCompleted: true
  },
  {
    id: 3,
    text: "hello3",
    isCompleted: true
  },
  {
    id: 4,
    text: "hello4",
    isCompleted: true
  },
  {
    id: 5,
    text: "hello5",
    isCompleted: true
  },
  {
    id: 6,
    text: "hello6",
    isCompleted: false
  }
];

// loops
for (let todo of todos) {
  console.log(todo);
}

todos.forEach(todo => console.log(todo));
// map creates the new array
const todoTexts = todos.map(todo => todo.text);
console.log(todoTexts);

// filter
const filteredTodos = todos.filter(todo => todo.isCompleted);
console.log(filteredTodos);

// function
const addNums = (num1 = 1, num2 = 2) => {
  console.log(num1 + num2);
};

addNums();
addNums(5, 5);
addNums(3);

//OOP
// this is ES5
// Constructor
function Person(firstName, lastName, dob) {
  this.firstName = firstName;
  this.lastName = lastName;
  this.dob = new Date(dob);
}

Person.prototype.getBirthYear = function() {
  return this.dob.getFullYear();
};

// ES5 mentions about 'prototype', but we don't have to worry about it in ES6

const person1 = new Person("Yudai", "Yaguchi", "12-3-1980");
console.log(person1);
console.log(person1.firstName);
console.log(person1.getBirthYear());

// this is ES6
class Person2 {
  constructor(firstName, lastName, dob) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = new Date(dob);
  }

  getBirthYear() {
    return this.dob.getFullYear();
  }
}

const person2 = new Person2("Yudai", "Yaguchi", "12-3-1980");
console.log(person2);
console.log(person2.firstName);
console.log(person2.getBirthYear());
