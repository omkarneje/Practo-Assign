import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import PatientRegistration from './pages/PatientRegistration';
import AppointmentBooking from './pages/AppointmentBooking';
import DoctorConsultation from './pages/DoctorConsultation';
import AppointmentsList from './pages/AppointmentList'
import './output.css'
const App = () => {
  return (
    <Router>
      <div className="min-h-screen bg-gray-100 p-4">
        <h1 className="text-4xl font-bold text-center mb-12 text-gray-800">Hospital Management System</h1>
        <nav className="mb-12">
          <ul className="flex justify-center space-x-6">
            <li>
              <Link to="/" className="text-blue-600 hover:text-blue-800">Patient Registration</Link>
            </li>
            <li>
              <Link to="/appointments" className="text-green-600 hover:text-green-800">Appointment Booking</Link>
            </li>
            <li>
              <Link to="/consultation" className="text-red-600 hover:text-red-800">Doctor Consultation</Link>
            </li>
            <li>
            <Link to="/appointment-list" className="text-yellow-500 hover:text-yellow-800">Appointments List</Link>
            </li>
          </ul>
        </nav>
        <Routes>
          <Route path="/" element={<PatientRegistration />} />
          <Route path="/appointments" element={<AppointmentBooking />} />
          <Route path="/consultation" element={<DoctorConsultation />} />
          <Route path="/appointment-list" element={<AppointmentsList />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
