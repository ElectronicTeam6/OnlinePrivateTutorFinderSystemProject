import { last } from "rxjs";

export interface User {
    userId: number,
    firstName: string,
    lastName: string,
    email: string,
    password: string,
    phoneNo: number;
    isAdmin: boolean,
    isParent: boolean,
    isTutor: boolean,
};

// export let Users: User[] = [{
//     userId: 100,
//     firstName: "Nikhil",
//     lastName: "Dubey",
//     email: "20.nikhildubey@gmail.com",
//     password: "123",
//     phoneNo: 8962132378,
//     isAdmin: false,
//     isParent: true,
//     isTutor: false
// }];

// export let setUser = (uList: User) => Users.concat(uList);
