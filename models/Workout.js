const mongoose = require('mongoose')
const Schema = mongoose.Schema

const workoutSchema = new Schema({
    title: {
        type: String,
        unique: true
    },
    repeatCount: {
        type: String,
    },
    timeWorkout: {
        type: String,
    },
    setCount: {
        type: String,
    },
    weightEquip: {
        type: String
    },
    restTime: {
        type: String
    },
    user: {
        ref: 'users',
        type: Schema.Types.ObjectId
    }
})

module.exports = mongoose.model('workouts', workoutSchema)