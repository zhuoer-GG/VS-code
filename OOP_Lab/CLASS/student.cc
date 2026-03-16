#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<limits>

class student_info 
{
private:
    std::string name;
    double midterm,final;
    std::vector<double> homework;
public:
    double grade() const;
    std::istream& read(std::istream& in);
    std::string get_name() const { return name; }
    std::vector<double> get_homework() const { return homework; }
    void set_name(const std::string& n) { name = n; }
    bool valid() const { return homework.empty(); }
    
    student_info() : midterm(0), final(0) {}
    student_info(std::istream& in) { read(in); }
    ~student_info() {
        // No dynamic memory allocation in this class, so no special cleanup is needed.
        // Destructor is defined explicitly for clarity or future-proofing.
    }
};
std::istream& student_info::read(std::istream& in) // Read student information from input stream
{
    in >> name >> midterm >> final;
    homework.clear();
    double x;
    while (in >> x) { // read six or less homework scores
        homework.push_back(x);
        if (homework.size() == 6) {
            break; // only read six homework scores
        }
    }
    if (in.fail()) {
        in.clear();
        in.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    }
    return in;
}
double student_info::grade() const
{
    if (homework.empty()) {
        return 0;
    }
    double sum = 0;
    for (double h : homework) {
        sum += h;
    }
    return (midterm + final + sum) / (2 + homework.size());
}

bool compare(const student_info& s1, const student_info& s2)
{
    return s1.get_name() < s2.get_name();
}

int main(){
    student_info s1, s2;
    std::cout << "Enter student 1 details (name midterm final homework scores): ";
    s1.read(std::cin);
    std::cout << "Enter student 2 details (name midterm final homework scores): ";
    s2.read(std::cin);
    std::cout << "Student 1: " << s1.get_name() << ", Grade: " << s1.grade() << std::endl;
    std::cout << "Student 2: " << s2.get_name() << ", Grade: " << s2.grade() << std::endl;
    if (compare(s1, s2)) {
        std::cout << s1.get_name() << " comes before " << s2.get_name() << std::endl;
    } else {
        std::cout << s2.get_name() << " comes before " << s1.get_name() << std::endl;
    }
    std::cout << "Student 1 valid: " << (s1.valid() ? "true" : "false") << std::endl;
    std::cout << "Student 2 valid: " << (s2.valid() ? "true" : "false") << std::endl;
    std::cout << "Student 1 homework scores: ";
    for (double h : s1.get_homework()) {
        std::cout << h << " ";
    }
    std::cout << std::endl;

    return 0;
}