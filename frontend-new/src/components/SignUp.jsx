// SignUp.js

import { useState } from 'react';
import axios from "axios"

const SignUp = () => {
  // State to store form input values
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
  });

  // Handle form input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  // Handle form submission
  async function handleSubmit(e) {
    e.preventDefault();
    // Add logic for submitting the form data (e.g., send to backend API)
    console.log('Form submitted:', formData);
    // Reset form after submission
    setFormData({
      username: '',
      email: '',
      password: '',
    });
    await axios.post("http://localhost:8080/api/users/signup", formData)
  }

  return (
    <div>
      <h2>Sign Up</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Username:
          <input
            type="text"
            name="username"
            value={formData.username}
            onChange={handleChange}
            required
          />
        </label>
        <br />
        <label>
          Email:
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </label>
        <br />
        <label>
          Password:
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </label>
        <br />
        <button type="submit">Sign Up</button>
      </form>
    </div>
  );
};

export default SignUp;
