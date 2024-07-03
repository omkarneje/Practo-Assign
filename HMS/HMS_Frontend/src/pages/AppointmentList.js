import React, { useState, useEffect } from 'react';
import axios from 'axios';

const AppointmentsList = () => {
  const [searchQuery, setSearchQuery] = useState('');
  const [appointments, setAppointments] = useState([]);
  const [filteredAppointments, setFilteredAppointments] = useState([]);

  useEffect(() => {
    fetchAppointments();
  }, []);

  const fetchAppointments = async () => {
    try {
      const response = await axios.get('http://localhost:8080/appointments');
      setAppointments(response.data);
      setFilteredAppointments(response.data); // Initially set filteredAppointments to all appointments
    } catch (error) {
      console.error('Error fetching appointments:', error);
    }
  };

  const handleSearchChange = (event) => {
    setSearchQuery(event.target.value);
    filterAppointments(event.target.value);
  };

  const filterAppointments = (query) => {
    const filtered = appointments.filter(appointment =>
      appointment.patientName.toLowerCase().includes(query.toLowerCase()) ||
      appointment.doctorName.toLowerCase().includes(query.toLowerCase())
    );
    setFilteredAppointments(filtered);
  };

  return (
    <div className="mt-4 ml-8 mr-8">
      <div className="flex justify-center mb-4">
        <label className="mt-2.5 mr-2.5">Search:</label>
        <input
          type="text"
          placeholder="Patient/Doctor Name"
          value={searchQuery}
          onChange={handleSearchChange}
          className="p-2 mt-0.5 border border-gray-300 rounded-md"
        />
      </div>
      <ul className="mt-8 ">
        {filteredAppointments.map((appointment) => (
          <li key={appointment.id} className="mb-2 p-2 border rounded-md">
            <p><strong>Patient Name:</strong> {appointment.patientName}</p>
            <p><strong>Doctor Name:</strong> {appointment.doctorName}</p>
            <p><strong>Date:</strong> {appointment.date}</p>
            <p><strong>Time:</strong> {appointment.time}</p>
            {/* Add other appointment details */}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AppointmentsList;
