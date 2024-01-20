
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignUp from './components/SignUp';
import Login from './components/Login';
import AboutMe from './components/AboutMe';
import HomePage from './components/HomePage';

function App() {
  return (
    <Router>
     
        <Routes>
        <Route path="/" element={<HomePage/>} /> 
          <Route path="/signup" element={<SignUp />} />
          <Route path="/login" element={<Login />} />
          <Route path="/aboutme" element={<AboutMe />} />
        </Routes>
   
    </Router>
  );
}

export default App;
