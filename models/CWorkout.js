const mongoose = require('mongoose')
const Schema = mongoose.Schema

const comworkoutSchema = new Schema({
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
    }
})

module.exports = mongoose.model('cworkouts', comworkoutSchema)