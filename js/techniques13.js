// 컬렉션 캡슐화 하기

class Person {
  constructor(name) {
    this._name = name;
    this._courses = [];
  }

  get name() {
    return this._name;
  }
  get courses() {
    return this._courses;
  }
  set courses(aList) {
    this._courses = aList;
  }
}

class Course {
  constructor(name, isAdvanced) {
    this._name = name;
    this._isAdvanced = isAdvanced;
  }

  get name() {
    return this._name;
  }
  get isAdvanced() {
    return this._isAdvanced;
  }
}

aPerson = new Person("name");
numAdvancedCourses = aPerson.courses.filter((c) => c.isAdvanced).length;

// 세터를 이용한 컬렉션을 통째로 수정가능 캡슐화 안되어있음.
const basicCourseNames = readBasicCourseNames(filename);
aPerson.courses = basicCourseNames.map((name) => new Course(name, false));
// 클라이언트 입장에선 바로 직접적으로 수정하는편이 편할 수 있다.
for (const name of readBasicCourseNames(filename)) {
  aPerson.courses.push(new Course(name, false));
}

// 필드에 담긴 내용 캡슐화 하기 캡슐화 하기
class Person {
  constructor(name) {
    this._name = name;
    this._courses = [];
  }

  get name() {
    return this._name;
  }
  get courses() {
    return this._courses.slice();
  }

  //  세터를 제공해야하는 특별한 이유가 ㅣㅇㅆ다면 컬렉션의 복제본을 필드에 저장
  set courses(aList) {
    this._courses = aList.slice();
  }

  addCourse(aCourse) {
    this._courses.push(aCourse);
  }

  removeCourse(
    aCourse,
    fnIfAbsent = () => {
      throw new RangeError();
    }
  ) {
    const index = this._courses.indexOf(aCourse);
    if (index === -1) fnIfAbsent();
    else this._courses.splice(index, 1);
  }
}

// 변경된 컬렉션 캡슐화 사용하기
for (const name of readBasicCourseNames(filename)) {
  aPerson.courses.addCourse(new Course(name, false));
}
