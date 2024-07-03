import React, { useState } from 'react';
import axios from 'axios';

const PatientRegistration = () => {
  const [patient, setPatient] = useState({
    name: '',
    age: '',
    contact: '',
    insurance: '',
    email: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setPatient({
      ...patient,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/patients', patient);
      console.log('Patient Registered:', response.data);
      // Optionally reset form fields after successful submission
      setPatient({
        name: '',
        age: '',
        contact: '',
        insurance: '',
        email: ''
      });
    } catch (error) {
      console.error('Error registering patient:', error);
    }
  };

  return (
    <div className="max-w-lg mx-auto p-6 bg-white shadow-lg rounded-lg border-t-4 border-blue-600">
      <h2 className="text-3xl font-semibold text-center mb-6 text-blue-600">Patient Registration</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <label className="block text-gray-700 font-medium mb-2">Name:</label>
          <input
            type="text"
            name="name"
            value={patient.name}
            onChange={handleChange}
            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-600"
            placeholder="Enter patient's name"
            required
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 font-medium mb-2">Age:</label>
          <input
            type="number"
            name="age"
            value={patient.age}
            onChange={handleChange}
            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-600"
            placeholder="Enter patient's age"
            required
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 font-medium mb-2">Contact:</label>
          <input
            type="text"
            name="contact"
            value={patient.contact}
            onChange={handleChange}
            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-600"
            placeholder="Enter patient's contact number"
            required
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 font-medium mb-2">Insurance:</label>
          <input
            type="text"
            name="insurance"
            value={patient.insurance}
            onChange={handleChange}
            className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-600"
            placeholder="Enter patient's insurance details"
          />
        </div>
        <button type="submit" className="w-full bg-blue-600 text-white py-2 rounded-md hover:bg-blue-700 transition duration-300">
          Register
        </button>
      </form>
    </div>
  );
};

export default PatientRegistration;
