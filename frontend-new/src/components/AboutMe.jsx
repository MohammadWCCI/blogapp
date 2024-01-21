// AboutMe.js

import  { useEffect, useState } from 'react';

const AboutMe = () => {
  // State to store user information
  const [userData, setUserData] = useState(null);
  

  // Simulating user authentication and fetching user data
  useEffect(() => {
    // Replace this with actual logic to fetch user data from your backend
    // For demonstration purposes, it sets a mock user data after a delay
    const fetchUserData = async () => {
      // Simulating an API request delay (remove this in a real application)
      await new Promise((resolve) => setTimeout(resolve, 1000));
      await axios.get(`http://localhost:8080/api/about-me/${username}`)
      
      // Mock user data (replace with actual logic)
      const mockUserData = {
        username: 'JohnDoe',
        email: 'john.doe@example.com',
        // Additional user information...
      };

      setUserData(mockUserData);
    };

    fetchUserData();
  }, []);

  return (
    <div>
      <h2>About Me</h2>
      {userData ? (
        <div>
          <p>Username: {userData.username}</p>
          <p>Email: {userData.email}</p>
          {/* Additional user information... */}
        </div>
      ) : (
        <p>Loading user data...</p>
      )}
    </div>
  );
};

export default AboutMe;
