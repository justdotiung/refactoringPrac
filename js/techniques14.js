// 기본형을 객체로 바꾸기.

class Order {
  constructor(data) {
    this.priority = data.priority;
    //나머지 생략
  }

  get priorityString() {
    return this._priority.toString();
  }

  get priority() {
    return this._priority;
  }
  set priority(aString) {
    this._priority = new Priority(aString);
  }
}

class Priority {
  constructor(value) {
    if (value instanceof Priority) return value;
    if (Priority.legalValues().includes(value)) this._value = value;
    else throw new Error(`<${value}> is invalid for Priority`);
  }

  toString() {
    return this._value;
  }

  get _index() {
    return Priority.legalValues().findIndex((s) => s === this._value);
  }

  static legalValues() {
    return ["low", "nomal", "high", "rush"];
  }

  equals(other) {
    return this._index === other._index;
  }
  highterThan(other) {
    return this._index > other._index;
  }
  lowerThan(other) {
    return this._index < other._index;
  }
}

highPriorityCount = order.filter(
  // (o) => "high" === o.priority.toString() || "rush" === o.priority.toString()
  (o) => o.priority.highterThan(new Priority("nomal"))
).length;
