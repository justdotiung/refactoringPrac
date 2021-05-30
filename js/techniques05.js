/**
 * 함수 선언 바꾸기
 */

// 간단한 절차

function circum(radius) {
  return 2 * Math.PI * radius;
}

function circumference(radius) {
  return 2 * Math.PI * radius;
}

// 매개변수 추가하기

class Book {
  addReservation(customer) {
    this._reservation.push(customer);
  }
}

class Book {
  addReservation(customer) {
    this.zz_addReservation(customer, false);
  }
  zz_addReservation(customer, isPriority) {
    this._reservation.push(customer);
  }
}

// 매개변수를 속성으로 바꾸기

function inNewEngland(aCustomer) {
  return ["MA", "CT", "ME", "VI", "NH", "RI"].includes(aCustomer.address.state);
}

const newEnglanders = someCustomers.filter((c) => inNewEngland(c));

function inNewEngland(stateCode) {
  return ["MA", "CT", "ME", "VI", "NH", "RI"].includes(stateCode);
}

const newEnglanders = someCustomers.filter((c) =>
  inNewEngland(c.address.state)
);
