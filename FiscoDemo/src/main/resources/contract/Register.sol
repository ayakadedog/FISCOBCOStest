// SPDX-License-Identifier: Apache-2.0
pragma solidity >=0.6.10 <0.8.20;
pragma experimental ABIEncoderV2;

contract Register {
    struct User {
        string username;
        string password;
    }

    mapping(address => User) public users;
    address[] public userAddresses;

    event UserRegistered(address indexed userAddress, string username);
    event UserLoggedIn(address indexed userAddress);

    function registerUser(string memory _username, string memory _password) public {
        require(bytes(_username).length > 0, "Username cannot be empty");
        require(bytes(_password).length > 0, "Password cannot be empty");
        require(keccak256(bytes(users[msg.sender].username)) == keccak256(bytes("")), "User already registered");

        users[msg.sender] = User(_username, _password);
        userAddresses.push(msg.sender);
        emit UserRegistered(msg.sender, _username);
    }

    function loginUser(string memory _username, string memory _password) public {
        require(bytes(_username).length > 0, "Username cannot be empty");
        require(bytes(_password).length > 0, "Password cannot be empty");

        User storage user = users[msg.sender];
        require(keccak256(bytes(user.username)) == keccak256(bytes(_username)), "Invalid username");
        require(keccak256(bytes(user.password)) == keccak256(bytes(_password)), "Invalid password");

        emit UserLoggedIn(msg.sender);
    }

    function getUserCount() public view returns (uint) {
        return userAddresses.length;
    }
}