#!/bin/bash

#This bash file cleans up the compiled .class files to reduce clutter.
#If you find ur working directory filled with .class files running this would clean it up. :)

project_dir="$(cd "$(dirname "$0")" && pwd)"

find_and_list_class_files() {
  find "$project_dir" -type f -name "*.class"
}

confirm_delete() {
  read -p "Do you want to delete the listed .class files? (yes/no): " choice
  case "$choice" in
    y|Y|yes|Yes|YES)
      delete_class_files
      ;;
    *)
      echo "No files deleted."
      ;;
  esac
}

delete_class_files() {
  find_and_list_class_files | while read -r class_file; do
    rm "$class_file"
    echo "Deleted: $class_file"
  done
  echo "All .class files deleted."
}

class_files=$(find_and_list_class_files)

if [ -n "$class_files" ]; then
  echo "The following .class files were found in the project:"
  echo "$class_files"
  confirm_delete
else
  echo "No .class files found in the project."
fi
