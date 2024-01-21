// Login.js

import { useState } from 'react';

const Login = () => {
  // State to store form input values
  const [formData, setFormData] = useState({
    username: '',
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
  async function handleSubmit (e){
    e.preventDefault();
    // Add logic for submitting the form data (e.g., send to backend API)
    console.log('Form submitted:', formData);
    // Reset form after submission
    setFormData({
      username: '',
      password: '',
    });
    await axios.post("http://localhost:8080/api/users/login", formData)
  };

  return (
    <div>
      <h2>Login</h2>
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
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
