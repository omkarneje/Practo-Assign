import React, { useState } from 'react';
import axios from 'axios';

const AppointmentBooking = () => {
  const [appointment, setAppointment] = useState({
    patientName: '',
    doctorName: '',
    date: '',
    time: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setAppointment({
      ...appointment,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/appointments', appointment);
      console.log('Appointment Booked:', response.data);
      // Optionally reset form fields after successful submission
      setAppointment({
        patientName: '',
        doctorName: '',
        date: '',
        time: '',
      });
    } catch (error) {
      console.error('Error booking appointment:', error);
    }
  };

  return (
    <div className="max-w-lg mx-auto p-6 bg-white shadow-lg rounded-lg border-t-4 border-green-600">
      <h2 className="text-3xl font-semibold text-center mb-6 text-green-600">Book Appointment</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <label className="block text-gray-700 font-medium mb-2">Patient Name:</label>
          <input
            type="text"
            name="patientName"
            value={appointment.patientName}
            onChange={handleChange}
            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-600"
            placeholder="Enter patient's name"
            required
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 font-medium mb-2">Doctor Name:</label>
          <input
            type="text"
            name="doctorName"
            value={appointment.doctorName}
            onChange={handleChange}
            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-600"
            placeholder="Enter doctor's name"
            required
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 font-medium mb-2">Date:</label>
          <input
            type="date"
            name="date"
            value={appointment.date}
            onChange={handleChange}
            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-600"
            required
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 font-medium mb-2">Time:</label>
          <input
            type="time"
            name="time"
            value={appointment.time}
            onChange={handleChange}
            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-600"
            required
          />
        </div>
        <button type="submit" className="w-full bg-green-600 text-white py-2 rounded-md hover:bg-green-700 transition duration-300">
          Book Appointment
        </button>
      </form>
    </div>
  );
};

export default AppointmentBooking;
